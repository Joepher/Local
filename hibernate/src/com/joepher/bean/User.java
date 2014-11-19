package com.joepher.bean;

/**
 * DbUserId entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable
{
	private static final long serialVersionUID = -7410761767950497642L;

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Integer age;

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** full constructor */
	public User(String username, String password, Integer age)
	{
		this.username = username;
		this.password = password;
		this.age = age;
	}

	// Property accessors

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof User))
			return false;
		User castOther = (User) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(
						castOther.getPassword())))
				&& ((this.getAge() == castOther.getAge()) || (this.getAge() != null
						&& castOther.getAge() != null && this.getAge().equals(castOther.getAge())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result + (getAge() == null ? 0 : this.getAge().hashCode());
		return result;
	}

}
