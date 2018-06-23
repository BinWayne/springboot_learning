package com.ibm.dsw.pricepub.admin.dao;

import com.ibm.dsw.pricepub.admin.entity.JobTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Repository
public class JobDaoImpl implements  JobDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addJob(final JobTask job) {

        final String storedProc = "{call EBIZ1.I_PP_JOB_CFG(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int value = (int) jdbcTemplate.execute(new CallableStatementCreator() {
            public CallableStatement createCallableStatement(Connection con) throws SQLException {

                CallableStatement cs = con.prepareCall(storedProc);

                cs.setString(3,job.getJobTitle());
                cs.setString(4,job.getStartDate());
                cs.setString(5,job.getEndDate());
                cs.setString(6,job.getJobFreq());
                cs.setString(7, String.valueOf(job.getJobDtl()));
                cs.setString(8,String.valueOf(job.getJobSucc()));
                cs.setString(9,String.valueOf(job.getJobFail()));
                cs.setString(10,job.getAddByUserName());
                cs.setString(11,job.getModByUserName());
                cs.setString(12,String.valueOf(job.getInactFlag()));
                cs.setString(13,job.getFileCfgIDs());

                cs.registerOutParameter(1,Types.INTEGER);
                cs.registerOutParameter(2,Types.INTEGER);// 注册输出参数的类型
                return cs;
            }
        }, new CallableStatementCallback() {
            public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.execute();
                int jobId = cs.getInt(2);
                System.out.println("job id ->>"+jobId);
                return cs.getInt(1);// 获取输出参数的值
            }
        });
       return value;

    }

    @Override
    public void selectAllJob() {

    }

    @Override
    public int updateJob(final JobTask job) {

        final String storedProc = "{call EBIZ1.U_PP_JOB_CFG(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int value = (int) jdbcTemplate.execute(new CallableStatementCreator() {
            public CallableStatement createCallableStatement(Connection con) throws SQLException {

                CallableStatement cs = con.prepareCall(storedProc);
                cs.setInt(2,job.getJobID());
                cs.setString(3,job.getJobTitle());
                cs.setString(4,job.getStartDate());
                cs.setString(5,job.getEndDate());
                cs.setString(6,job.getJobFreq());
                cs.setString(7,String.valueOf(job.getJobDtl()));
                cs.setString(8,String.valueOf(job.getJobSucc()));
                cs.setString(9,String.valueOf(job.getJobFail()));
                cs.setString(10,job.getModByUserName());
                cs.setString(11,String.valueOf(job.getInactFlag()));
                cs.setString(12,job.getFileCfgIDs());

                cs.registerOutParameter(1,Types.INTEGER);

                return cs;
            }
        }, new CallableStatementCallback() {
            public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.execute();
                return cs.getInt(1);// 获取输出参数的值
            }
        });
        return value;
    }

    @Override
    public void deleteJob(int jobId) {

    }
}
