package com.zoho.crm.api.wizards;

import com.zoho.crm.api.fields.Field;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Actions implements Model
{
	private Long id;

	private String type;

	private Segment segment;

	private Field fields;

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
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of segment
	 * @return An instance of Segment
	 */
	public Segment getSegment()
	{
		return  this.segment;

	}

	/**
	 * The method to set the value to segment
	 * @param segment An instance of Segment
	 */
	public void setSegment(Segment segment)
	{
		 this.segment = segment;

		 this.keyModified.put("segment", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of Field
	 */
	public Field getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of Field
	 */
	public void setFields(Field fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

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