package com.zoho.crm.api.users;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class TransferringResponseWrapper implements Model, ResponseHandler
{
	private List<Territory> validateBeforeTransfer;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of validateBeforeTransfer
	 * @return An instance of List<Territory>
	 */
	public List<Territory> getValidateBeforeTransfer()
	{
		return  this.validateBeforeTransfer;

	}

	/**
	 * The method to set the value to validateBeforeTransfer
	 * @param validateBeforeTransfer An instance of List<Territory>
	 */
	public void setValidateBeforeTransfer(List<Territory> validateBeforeTransfer)
	{
		 this.validateBeforeTransfer = validateBeforeTransfer;

		 this.keyModified.put("validate_before_transfer", 1);

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