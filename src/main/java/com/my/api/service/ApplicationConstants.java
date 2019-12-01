package com.my.api.service;

/**
 * The Class ApplicationConstants.
 * 
 */
public final class ApplicationConstants 
{

	public static final String INSTRUCTIONS = "<h1 style=\"color: #5e9ca0;\"><strong>Try out the application</strong></h1>\n" + 
			"<p>&nbsp;</p>\n" + 
			"<h2 style=\"color: #2e6c80;\">Open a web browser and type :</h2>\n" + 
			"<table class=\"editorDemoTable\" style=\"background-color: #add8e6;\" border=\"2\" cellspacing=\"2\">\n" + 
			"<thead>\n" + 
			"<tr>\n" + 
			"<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong>APIs</strong></td>\n" + 
			"<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong>Result</strong></td>\n" + 
			"</tr>\n" + 
			"</thead>\n" + 
			"<tbody>\n" + 
			"<tr>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">http://localhost:8080/users</pre>\n" + 
			"</td>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">Returns all the users(There are 10 dummy users).<br /><br /></pre>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"<tr>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">http://localhost:8080/user/{id}</pre>\n" + 
			"</td>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">Returns a single user that matches the id(id should be between 1-10 as<br />there are just 10 dummy users,otherwise it retuns 404 Not Found.<br /><br /></pre>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"<tr>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">http://localhost:8080/instructions</pre>\n" + 
			"</td>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">Returns the instructions.<br /><br /></pre>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"<tr>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">http://localhost:8080/city/{city}/user</pre>\n" + 
			"</td>\n" + 
			"<td>\n" + 
			"<pre class=\"tab\">Retuns people who are listed as either living in London,or whose current<br />coordinates are within 50 miles of London. The following cities can be <br />choosen:<br /><strong>1-London</strong><br />2-less than 50 miles far from London<br /><strong>  .Reading</strong><br /><strong>  .Leatherhead</strong><br /><strong>  .Woking</strong></pre>\n" + 
			"<pre class=\"tab\">3-more than 50 miles far from London<br /><strong>  .Bath</strong><br /><strong>  .Norwich</strong><br /><strong>  .Leeds</strong><br />  <br />If the city&rsquo;s coordinates aren&rsquo;t within 50 miles, the api returns <br />an empty list.</pre>\n" + 
			"</td>\n" + 
			"</tr>\n" + 
			"</tbody>\n" + 
			"</table>\n" + 
			"<p>&nbsp;</p>\n" + 
			"<p><strong>&nbsp;</strong></p>";
		
	
	//London's Latitude from a random postCode 
	public static final double LNG1 = 51.60804;
	
	//London's Longitude from a random postCode 
	public static final double LAT1 = -0.191641;
	
	public static final String LONDON = "London";
	
	public static final String POST_CODE = "N12 6PQ";
    
	public static final String LEEDS = "Leeds";
    
	public static final String ID1 = "1";
    
	public static final String ID2 = "2";
    
	public static final String NAME1 = "John Smith";
    
	public static final String NAME2 = "Rose Watt";
	
	public static final String MESSAGE = "User id is not found";
    
	public static final String ERROR = "error";
  
	
	/**
     * Constructor for ExceptionConstants class.
     */
    private ApplicationConstants ()
    {
        // Do nothing as it's private.
    }

}
