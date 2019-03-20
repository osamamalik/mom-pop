# e-men

FIXES:

- addUser query was fixed: changed the PreparedStatement declaration to Statement. We need a Statement object when adding/updating items to tables.

- other queries were fixed: Connection, PreparedStatement and ResultSet objects were not closed after queries. Added closing statements.
without the closing statements website kept locking

- there was an error on login error checking. 2 queries were called from the same method (checkUserExists and passwordValidation).
apparently there can only be one ResultSet open at a time. one of these methods locked the other one which kept giving SQl errors.
instead of using a ResultSet, called the next() method directly on p.executeQuery() on checkUserExists, this fixed the issue.

ADDITIONS:

- added error checking for signUp
- added updatePassword method to model


***************************************************************************************************************************************************
***************************************************************************************************************************************************


Tuesday, March 19, 2019:

FIXES:

- The database issue where added tables were not found.
- ***if this happens, choose 'Upgrade Database to Current Version' under your database properties, and change the url in your context.xml accordingly***

ADDITIONS:

- BookBean, BookDOA, corresponding methods inside model
- Updated the BookBean with fields of description, publishYear, and review.
- Updated the SQL tables with above (saved in DBCreate.sql)
- Added a header to all pages. The header shows signup and login if user hasn't signed in, cart and checkout if user has signed in
	- Header has a 'Specials' button I haven't implemented yet. We can add a sale feature and show only the books that are on sale when this button is clicked
- Added a search bar.
	- You can do a store-wide search, which will be useful. However this is case sensitive so it will need to be fixed.
	- The search checks for title, author, category. If there's anything else, we can just edit the retrieveBySearch query
- Added a singleBook.jspx, but only added a header so far. 
- Added a "sort by" dropdown menu, but haven't implemented it yet. In the servlet we can see what the user chose to sort by, but it doesn't return anything yet.
	- My thought was to sort the 'books' map and display it again, but sorting this map by a field of its value is harder than I thought it would be. Let's discuss this.
- Added a signout button and implemented it
