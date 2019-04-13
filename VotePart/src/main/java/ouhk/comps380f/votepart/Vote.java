/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ouhk.comps380f.votepart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yungtszhin
 */
public class Vote implements Serializable {

    private String username;
    private int questionId;
    private String userAnswer;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int voteToDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn;
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("INSERT INTO VOTE(username,questionID,answer) VALUES(?,?,?) ");
        ps.setString(1, username);
        ps.setInt(2, questionId);
        ps.setString(3, userAnswer);

        int a = ps.executeUpdate();

        conn.close();

        if (a == 1) {
            return a;
        } else {
            return a;
        }

    }

    public int checkVoted() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        int check = 0;
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("Select * FROM VOTE WHERE USERNAME = ? AND QUESTIONID = ?");
        ps.setString(1, username);
        ps.setInt(2, questionId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            check++;
        }

        rs.close();
        conn.close();
        return check;
    }

    public String FormResult() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("Select USERNAME,QUESTIONID,ANSWER FROM VOTE WHERE USERNAME = ? ");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString(1);
            String qid = rs.getString(2);
            String ans = rs.getString(3);
            return "You are: " + name + "<br /> Your Choice: " + ans;
        }

        rs.close();
        conn.close();
        return null;
    }

    public int editToDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn;
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("UPDATE Vote SET Answer = ? WHERE Username = ? AND Questionid = ?");

        ps.setString(1, userAnswer);
        ps.setString(2, username);
        ps.setInt(3, questionId);

        int a = ps.executeUpdate();

        conn.close();

        if (a == 1) {
            return a;
        } else {
            return a;
        }
    }

    public String voteResult() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("Select answer, count(answer) From Vote Where questionID = ? Group By answer");
        ps.setInt(1, questionId);//hardcode of questionID
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String ans = rs.getString(1);
            String count = rs.getString(2);
            return "Question: :" +questionId+ "<br />\n" + "Answer " + ans + ": " + count;
        }

        rs.close();
        conn.close();
        return null;
    }

    public String questionGen() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("SELECT Question,ansA,ansB,ansC,ansD FROM QUESTIONDB where QuestionID = ?");
        ps.setInt(1, questionId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String Question = rs.getString(1);
            String ansA = rs.getString(2);
            String ansB = rs.getString(3);
            String ansC = rs.getString(4);
            String ansD = rs.getString(5);
            
            return "<form action=\"vote\" method=\"POST\">\n" +
"            <input type=\"hidden\" name=\"questionId\" value=\""+questionId+"\">\n" +
"            "+Question+" <br/>\n" +
"            <input type=\"radio\" name=\"userAnswer\" value=\""+ansA+"\"/> "+ansA+" <br/>\n" +
"            <input type=\"radio\" name=\"userAnswer\" value=\""+ansB+"\"/> "+ansB+" <br/>\n" +
"            <input type=\"radio\" name=\"userAnswer\" value=\""+ansC+"\"/> "+ansC+" <br/>\n" +
"            <input type=\"radio\" name=\"userAnswer\" value=\""+ansD+"\"/> "+ansD+" <br/>\n" +
"            <input type=\"submit\" value=\"Submit\"/>\n" +
"        </form>" ;
        }
        return null;
    }

}
