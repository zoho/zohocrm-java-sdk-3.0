package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class MultiUserLookup implements Model
{
	private String displayLabel;

	private Module linkingModule;

	private String lookupApiname;

	private Module connectedModule;

	private String apiName;

	private String connectedlookupApiname;

	private Long id;

	private Boolean recordAccess;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of linkingModule
	 * @return An instance of Module
	 */
	public Module getLinkingModule()
	{
		return  this.linkingModule;

	}

	/**
	 * The method to set the value to linkingModule
	 * @param linkingModule An instance of Module
	 */
	public void setLinkingModule(Module linkingModule)
	{
		 this.linkingModule = linkingModule;

		 this.keyModified.put("linking_module", 1);

	}

	/**
	 * The method to get the value of lookupApiname
	 * @return A String representing the lookupApiname
	 */
	public String getLookupApiname()
	{
		return  this.lookupApiname;

	}

	/**
	 * The method to set the value to lookupApiname
	 * @param lookupApiname A String representing the lookupApiname
	 */
	public void setLookupApiname(String lookupApiname)
	{
		 this.lookupApiname = lookupApiname;

		 this.keyModified.put("lookup_apiname", 1);

	}

	/**
	 * The method to get the value of connectedModule
	 * @return An instance of Module
	 */
	public Module getConnectedModule()
	{
		return  this.connectedModule;

	}

	/**
	 * The method to set the value to connectedModule
	 * @param connectedModule An instance of Module
	 */
	public void setConnectedModule(Module connectedModule)
	{
		 this.connectedModule = connectedModule;

		 this.keyModified.put("connected_module", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of connectedlookupApiname
	 * @return A String representing the connectedlookupApiname
	 */
	public String getConnectedlookupApiname()
	{
		return  this.connectedlookupApiname;

	}

	/**
	 * The method to set the value to connectedlookupApiname
	 * @param connectedlookupApiname A String representing the connectedlookupApiname
	 */
	public void setConnectedlookupApiname(String connectedlookupApiname)
	{
		 this.connectedlookupApiname = connectedlookupApiname;

		 this.keyModified.put("connectedlookup_apiname", 1);

	}

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
	 * The method to get the value of recordAccess
	 * @return A Boolean representing the recordAccess
	 */
	public Boolean getRecordAccess()
	{
		return  this.recordAccess;

	}

	/**
	 * The method to set the value to recordAccess
	 * @param recordAccess A Boolean representing the recordAccess
	 */
	public void setRecordAccess(Boolean recordAccess)
	{
		 this.recordAccess = recordAccess;

		 this.keyModified.put("record_access", 1);

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