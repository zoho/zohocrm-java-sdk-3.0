package com.zoho.crm.api.users;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Territory implements Model
{
	private Long id;

	private User manager;

	private String name;

	private Territory reportingTo;

	private Boolean records;

	private User transferToUser;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of manager
	 * @return An instance of User
	 */
	public User getManager()
	{
		return  this.manager;

	}

	/**
	 * The method to set the value to manager
	 * @param manager An instance of User
	 */
	public void setManager(User manager)
	{
		 this.manager = manager;

		 this.keyModified.put("Manager", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("Name", 1);

	}

	/**
	 * The method to get the value of reportingTo
	 * @return An instance of Territory
	 */
	public Territory getReportingTo()
	{
		return  this.reportingTo;

	}

	/**
	 * The method to set the value to reportingTo
	 * @param reportingTo An instance of Territory
	 */
	public void setReportingTo(Territory reportingTo)
	{
		 this.reportingTo = reportingTo;

		 this.keyModified.put("Reporting_To", 1);

	}

	/**
	 * The method to get the value of records
	 * @return A Boolean representing the records
	 */
	public Boolean getRecords()
	{
		return  this.records;

	}

	/**
	 * The method to set the value to records
	 * @param records A Boolean representing the records
	 */
	public void setRecords(Boolean records)
	{
		 this.records = records;

		 this.keyModified.put("records", 1);

	}

	/**
	 * The method to get the value of transferToUser
	 * @return An instance of User
	 */
	public User getTransferToUser()
	{
		return  this.transferToUser;

	}

	/**
	 * The method to set the value to transferToUser
	 * @param transferToUser An instance of User
	 */
	public void setTransferToUser(User transferToUser)
	{
		 this.transferToUser = transferToUser;

		 this.keyModified.put("transfer_to_user", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}