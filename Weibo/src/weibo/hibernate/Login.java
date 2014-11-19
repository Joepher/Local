package weibo.hibernate;

import java.util.Set;

/**
 * Login entity.
 */
public class Login extends AbstractLogin implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1523472655978302626L;

	// Constructors

	/** default constructor */
	public Login()
	{
	}

	/** minimal constructor */
	public Login(String loginName, String password)
	{
		super(loginName, password);
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public Login(String loginName, String password, Long loginType,
			Set userinfos)
	{
		super(loginName, password, loginType, userinfos);
	}

}
