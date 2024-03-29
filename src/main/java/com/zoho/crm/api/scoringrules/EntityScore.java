package com.zoho.crm.api.scoringrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class EntityScore implements Model
{
	private Entity entity;

	private Long id;

	private ScoringRule scoringRule;

	private Integer score;

	private Integer positiveScore;

	private Integer touchPointScore;

	private Integer negativeScore;

	private Integer positiveTouchPointScore;

	private Integer negativeTouchPointScore;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of entity
	 * @return An instance of Entity
	 */
	public Entity getEntity()
	{
		return  this.entity;

	}

	/**
	 * The method to set the value to entity
	 * @param entity An instance of Entity
	 */
	public void setEntity(Entity entity)
	{
		 this.entity = entity;

		 this.keyModified.put("Entity", 1);

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
	 * The method to get the value of scoringRule
	 * @return An instance of ScoringRule
	 */
	public ScoringRule getScoringRule()
	{
		return  this.scoringRule;

	}

	/**
	 * The method to set the value to scoringRule
	 * @param scoringRule An instance of ScoringRule
	 */
	public void setScoringRule(ScoringRule scoringRule)
	{
		 this.scoringRule = scoringRule;

		 this.keyModified.put("Scoring_Rule", 1);

	}

	/**
	 * The method to get the value of score
	 * @return An Integer representing the score
	 */
	public Integer getScore()
	{
		return  this.score;

	}

	/**
	 * The method to set the value to score
	 * @param score An Integer representing the score
	 */
	public void setScore(Integer score)
	{
		 this.score = score;

		 this.keyModified.put("Score", 1);

	}

	/**
	 * The method to get the value of positiveScore
	 * @return An Integer representing the positiveScore
	 */
	public Integer getPositiveScore()
	{
		return  this.positiveScore;

	}

	/**
	 * The method to set the value to positiveScore
	 * @param positiveScore An Integer representing the positiveScore
	 */
	public void setPositiveScore(Integer positiveScore)
	{
		 this.positiveScore = positiveScore;

		 this.keyModified.put("Positive_Score", 1);

	}

	/**
	 * The method to get the value of touchPointScore
	 * @return An Integer representing the touchPointScore
	 */
	public Integer getTouchPointScore()
	{
		return  this.touchPointScore;

	}

	/**
	 * The method to set the value to touchPointScore
	 * @param touchPointScore An Integer representing the touchPointScore
	 */
	public void setTouchPointScore(Integer touchPointScore)
	{
		 this.touchPointScore = touchPointScore;

		 this.keyModified.put("Touch_Point_Score", 1);

	}

	/**
	 * The method to get the value of negativeScore
	 * @return An Integer representing the negativeScore
	 */
	public Integer getNegativeScore()
	{
		return  this.negativeScore;

	}

	/**
	 * The method to set the value to negativeScore
	 * @param negativeScore An Integer representing the negativeScore
	 */
	public void setNegativeScore(Integer negativeScore)
	{
		 this.negativeScore = negativeScore;

		 this.keyModified.put("Negative_Score", 1);

	}

	/**
	 * The method to get the value of positiveTouchPointScore
	 * @return An Integer representing the positiveTouchPointScore
	 */
	public Integer getPositiveTouchPointScore()
	{
		return  this.positiveTouchPointScore;

	}

	/**
	 * The method to set the value to positiveTouchPointScore
	 * @param positiveTouchPointScore An Integer representing the positiveTouchPointScore
	 */
	public void setPositiveTouchPointScore(Integer positiveTouchPointScore)
	{
		 this.positiveTouchPointScore = positiveTouchPointScore;

		 this.keyModified.put("Positive_Touch_Point_Score", 1);

	}

	/**
	 * The method to get the value of negativeTouchPointScore
	 * @return An Integer representing the negativeTouchPointScore
	 */
	public Integer getNegativeTouchPointScore()
	{
		return  this.negativeTouchPointScore;

	}

	/**
	 * The method to set the value to negativeTouchPointScore
	 * @param negativeTouchPointScore An Integer representing the negativeTouchPointScore
	 */
	public void setNegativeTouchPointScore(Integer negativeTouchPointScore)
	{
		 this.negativeTouchPointScore = negativeTouchPointScore;

		 this.keyModified.put("Negative_Touch_Point_Score", 1);

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