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
public class Question implements Serializable{

    private String question;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }
    
    public int fakeAutoValue() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        int check = 0;
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("Select * FROM QuestionDB");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            check++;
        }
        return check;
    }

    public int questionToDB() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //String url = "jdbc:derby://localhost:1527/group_project;create=true;user=nbuser;password=nbuser";
        Connection conn;
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/group_project", "nbuser", "nbuser");

        PreparedStatement ps = conn.prepareStatement("INSERT INTO QUESTIONDB(QuestionID,Question,ansA,ansB,ansC,ansD) VALUES(?,?,?,?,?,?)");
        ps.setInt(1, fakeAutoValue()+1);
        ps.setString(2, question);
        ps.setString(3, ansA);
        ps.setString(4, ansB);
        ps.setString(5, ansC);
        ps.setString(6, ansD);
        
        
        int a = ps.executeUpdate();

        if (a == 1) {
            return a;
        } else {
            return a;
        }
    }

}
