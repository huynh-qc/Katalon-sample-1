import java.sql.Connection
import java.sql.ResultSet
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.annotation.TearDownIfPassed
import com.katalon.plugin.keyword.connection.DBType



Connection globalConnection = null;

ResultSet actorData;
//connection1 = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.postgresql, 'localhost', '5432', 'Alireview', 'postgres', 'postgres')
globalConnection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.getGlobalConnection'()
'Example: Insert statement record on database'

//def sql="update shops set test_status='pas66sed' where id=1"
println globalConnection
//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(globalConnection)
//actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(globalConnection, "SELECT * FROM shops")
//println CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, "id")

CustomKeywords.'database.postgres.update'()
//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate'(globalConnection,"update shops set test_status='pas66sed' where id=1")
//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(globalConnection)

//actorData = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(globalConnection, "SELECT * FROM shops")

//println CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue'(actorData, "test_status")

//CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(globalConnection)
@com.kms.katalon.core.annotation.TearDownIfFailed
def teardownIfFailed() {
	println "tetcase fail"
}
@com.kms.katalon.core.annotation.TearDownIfPassed
def teardownIfPassed() {
	println "tetcase passed ne"
}

