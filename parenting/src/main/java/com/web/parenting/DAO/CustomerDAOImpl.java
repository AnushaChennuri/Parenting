package com.web.parenting.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.web.parenting.model.CustomerDetailVO;
import com.web.parenting.model.CustomerVO;

@Repository
public class CustomerDAOImpl  implements CustomerDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	 
	
	@Autowired
	public CustomerDAOImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}

	public  CustomerVO isCustomerExsist(CustomerVO customer) {
		
		String sql = "select * from login where CustEmail = ?";
		 try{
		 CustomerVO customerDB=(CustomerVO)DataAccessUtils.singleResult(jdbcTemplate.query(sql, new Object[]{customer.getCustEmail()},new BeanPropertyRowMapper(CustomerVO.class)));
		 if(customerDB!=null && customerDB.getCustPassword()!=null){
			 if(PasswordEncryption.validatePassword(customer.getCustPassword(), customerDB.getCustPassword())){
				 return customerDB;
			 }else{
				 customerDB=null;
			 }
		 }
		 return customerDB;
		 }
		 catch(Exception e){
			 return null;//todo log the exception and propagate it
		 }
		
	}

	public CustomerVO insertNewCustomer(final CustomerDetailVO customerDetailVO) {
		
	//Generate encrypted password and then store that in DB.
	try {
		final String securePassword=PasswordEncryption.getEncryptedPassword(customerDetailVO.getCustomerVO().getCustPassword());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	   
		jdbcTemplate.update(new PreparedStatementCreator() {
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps = connection.prepareStatement(
	                    "INSERT INTO login (custEmail, custPassword, custTelephone) values (?, ?, ?)",
	                    new String[] { "id" });
	            ps.setString(1, customerDetailVO.getCustomerVO().getCustEmail());
	            ps.setString(2,securePassword);
	            ps.setString(3,customerDetailVO.getCustomerVO().getCustTelephone());
	            return ps;
	        }

			
	    }, keyHolder);
	    customerDetailVO.getCustomerVO().setCustId(keyHolder.getKey().intValue());
	    
	    jdbcTemplate.update(new PreparedStatementCreator() {
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps = connection.prepareStatement(
	                   "INSERT INTO address(address,address2,district,city,postal_code,last_update,state,country) values (?, ?, ?,?,?,?,?,?)",
	                    new String[] { "id" });
	            ps.setString(1, customerDetailVO.getAddressVO().getAddress());
	            ps.setString(2,customerDetailVO.getAddressVO().getAddress2());
	            ps.setString(3,customerDetailVO.getAddressVO().getDistrict());
	            ps.setString(4, customerDetailVO.getAddressVO().getCity());
	            ps.setString(5, customerDetailVO.getAddressVO().getPostal_code());
	            ps.setTimestamp(6, getCurrentTimeStamp());
	            ps.setString(7, customerDetailVO.getAddressVO().getState());
	            ps.setString(8, customerDetailVO.getAddressVO().getCountry());
	            return ps;
	        }

			
	    }, keyHolder);
	    
	    customerDetailVO.getAddressVO().setAddress_id(keyHolder.getKey().intValue()+"");
	    
	  String insertSql=  "INSERT INTO cust_detail (CustID,CustName,Cust_AddrID, Cust_Gender, CustSpouse,Cust_No_Kids) "
	  		+ "values (?,?,?,?,?,?)";
	  Object[] params = new Object[] {customerDetailVO.getCustomerVO().getCustId(),customerDetailVO.getCustName(),Integer.parseInt(customerDetailVO.getAddressVO().getAddress_id()),customerDetailVO.getCustGender(),customerDetailVO.getCustSpouse(),customerDetailVO.getCustNoKids()  };

	  jdbcTemplate.update(insertSql, params);
	}
	  
	  catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			 return null;//todo log the exception and propagate it
		 }
		
		return  customerDetailVO.getCustomerVO();
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
}
