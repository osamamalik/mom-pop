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
