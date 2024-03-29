package com.zoho.crm.api.layouts;

import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.users.User;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Layout implements Model
{
	private Boolean hasMoreProfiles;

	private OffsetDateTime createdTime;

	private Map<String, Object> convertMapping;

	private OffsetDateTime modifiedTime;

	private Boolean visible;

	private User createdFor;

	private String name;

	private User modifiedBy;

	private List<Profile> profiles;

	private String source;

	private Long id;

	private User createdBy;

	private List<Section> sections;

	private String displayLabel;

	private String status;

	private Integer displayType;

	private Boolean showBusinessCard;

	private ActionsAllowed actionsAllowed;

	private String generatedType;

	private String apiName;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of hasMoreProfiles
	 * @return A Boolean representing the hasMoreProfiles
	 */
	public Boolean getHasMoreProfiles()
	{
		return  this.hasMoreProfiles;

	}

	/**
	 * The method to set the value to hasMoreProfiles
	 * @param hasMoreProfiles A Boolean representing the hasMoreProfiles
	 */
	public void setHasMoreProfiles(Boolean hasMoreProfiles)
	{
		 this.hasMoreProfiles = hasMoreProfiles;

		 this.keyModified.put("has_more_profiles", 1);

	}

	/**
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of convertMapping
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getConvertMapping()
	{
		return  this.convertMapping;

	}

	/**
	 * The method to set the value to convertMapping
	 * @param convertMapping An instance of Map<String,Object>
	 */
	public void setConvertMapping(Map<String, Object> convertMapping)
	{
		 this.convertMapping = convertMapping;

		 this.keyModified.put("convert_mapping", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

	}

	/**
	 * The method to get the value of visible
	 * @return A Boolean representing the visible
	 */
	public Boolean getVisible()
	{
		return  this.visible;

	}

	/**
	 * The method to set the value to visible
	 * @param visible A Boolean representing the visible
	 */
	public void setVisible(Boolean visible)
	{
		 this.visible = visible;

		 this.keyModified.put("visible", 1);

	}

	/**
	 * The method to get the value of createdFor
	 * @return An instance of User
	 */
	public User getCreatedFor()
	{
		return  this.createdFor;

	}

	/**
	 * The method to set the value to createdFor
	 * @param createdFor An instance of User
	 */
	public void setCreatedFor(User createdFor)
	{
		 this.createdFor = createdFor;

		 this.keyModified.put("created_for", 1);

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

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of User
	 */
	public User getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of User
	 */
	public void setModifiedBy(User modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of profiles
	 * @return An instance of List<Profile>
	 */
	public List<Profile> getProfiles()
	{
		return  this.profiles;

	}

	/**
	 * The method to set the value to profiles
	 * @param profiles An instance of List<Profile>
	 */
	public void setProfiles(List<Profile> profiles)
	{
		 this.profiles = profiles;

		 this.keyModified.put("profiles", 1);

	}

	/**
	 * The method to get the value of source
	 * @return A String representing the source
	 */
	public String getSource()
	{
		return  this.source;

	}

	/**
	 * The method to set the value to source
	 * @param source A String representing the source
	 */
	public void setSource(String source)
	{
		 this.source = source;

		 this.keyModified.put("source", 1);

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
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of sections
	 * @return An instance of List<Section>
	 */
	public List<Section> getSections()
	{
		return  this.sections;

	}

	/**
	 * The method to set the value to sections
	 * @param sections An instance of List<Section>
	 */
	public void setSections(List<Section> sections)
	{
		 this.sections = sections;

		 this.keyModified.put("sections", 1);

	}

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
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of displayType
	 * @return An Integer representing the displayType
	 */
	public Integer getDisplayType()
	{
		return  this.displayType;

	}

	/**
	 * The method to set the value to displayType
	 * @param displayType An Integer representing the displayType
	 */
	public void setDisplayType(Integer displayType)
	{
		 this.displayType = displayType;

		 this.keyModified.put("display_type", 1);

	}

	/**
	 * The method to get the value of showBusinessCard
	 * @return A Boolean representing the showBusinessCard
	 */
	public Boolean getShowBusinessCard()
	{
		return  this.showBusinessCard;

	}

	/**
	 * The method to set the value to showBusinessCard
	 * @param showBusinessCard A Boolean representing the showBusinessCard
	 */
	public void setShowBusinessCard(Boolean showBusinessCard)
	{
		 this.showBusinessCard = showBusinessCard;

		 this.keyModified.put("show_business_card", 1);

	}

	/**
	 * The method to get the value of actionsAllowed
	 * @return An instance of ActionsAllowed
	 */
	public ActionsAllowed getActionsAllowed()
	{
		return  this.actionsAllowed;

	}

	/**
	 * The method to set the value to actionsAllowed
	 * @param actionsAllowed An instance of ActionsAllowed
	 */
	public void setActionsAllowed(ActionsAllowed actionsAllowed)
	{
		 this.actionsAllowed = actionsAllowed;

		 this.keyModified.put("actions_allowed", 1);

	}

	/**
	 * The method to get the value of generatedType
	 * @return A String representing the generatedType
	 */
	public String getGeneratedType()
	{
		return  this.generatedType;

	}

	/**
	 * The method to set the value to generatedType
	 * @param generatedType A String representing the generatedType
	 */
	public void setGeneratedType(String generatedType)
	{
		 this.generatedType = generatedType;

		 this.keyModified.put("generated_type", 1);

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