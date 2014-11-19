package weibo.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLogin entity provides the base persistence definition of the Login
 * entity.
 */

public abstract class AbstractLogin implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3413548482562227157L;

	// Fields

	private String loginName;
	private String password;
	private Long loginType;
	@SuppressWarnings("unchecked")
	private Set userinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractLogin()
	{
	}

	/** minimal constructor */
	public AbstractLogin(String loginName, String password)
	{
		this.loginName = loginName;
		this.password = password;
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public AbstractLogin(String loginName, String password, Long loginType,
			Set userinfos)
	{
		this.loginName = loginName;
		this.password = password;
		this.loginType = loginType;
		this.userinfos = userinfos;
	}

	// Property accessors

	public String getLoginName()
	{
		return this.loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Long getLoginType()
	{
		return this.loginType;
	}

	public void setLoginType(Long loginType)
	{
		this.loginType = loginType;
	}

	@SuppressWarnings("unchecked")
	public Set getUserinfos()
	{
		return this.userinfos;
	}

	@SuppressWarnings("unchecked")
	public void setUserinfos(Set userinfos)
	{
		this.userinfos = userinfos;
	}

}
