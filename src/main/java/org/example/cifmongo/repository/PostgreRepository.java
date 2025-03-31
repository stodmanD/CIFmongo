package org.example.cifmongo.repository;

import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.example.cifmongo.models.BasePostgre;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class PostgreRepository {
    private final JdbcTemplate jdbcTemplate;


    public PostgreRepository(@Qualifier("userJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String save(String payload) {
        log.info("Start call function save");
        String sql = "INSERT INTO test (payload) VALUES ('" + payload + "');";

        jdbcTemplate.execute(sql);
        return "ddd";
    }


    public String getById(int id) {
        log.info("Start call function getById");

        String sql = "select * from test where id=" + 2;
var result = jdbcTemplate.query(sql, (rs, rowNum) ->BasePostgre.builder()
        .id(rs.getInt("id"))
        .payload(rs.getString("payload")).build()).get(0);
        return result.getPayload().toString();

    }

    public String update(String payload, int id) {
        log.info("Start call function update");
        String sql = "UPDATE test SET payload ='" + payload + "' where id=" + id;

jdbcTemplate.execute(sql);
return "ddd";
//        return jdbcTemplate.queryForObject(sql, String.class);
    }
//
//    public String updateAllByThirdLevel(ThirdLevel thirdLevel) {
//        List<Base> list = postgreRepository.findAll();
//        for (Base obj : list) {
//            FirstLevel firstLevel = obj.getFirstLevel();
//            SecondLevel secondLevel = firstLevel.getSecondLevel();
//            secondLevel.setThirdLevel(thirdLevel);
//            firstLevel.setSecondLevel(secondLevel);
//            obj.setFirstLevel(firstLevel);
//            postgreRepository.save(obj);
//        }
//        return "Update successful";
//    }
//
//    public String updateAllBySecondLevel(SecondLevel secondLevel) {
//        var time = System.currentTimeMillis();
//        List<Base> list = postgreRepository.findAll();
//        var time2 = System.currentTimeMillis();
//        log.info("======time is {} ms", time2 - time);
//        for (Base obj : list) {
//            FirstLevel firstLevel = obj.getFirstLevel();
//            firstLevel.setSecondLevel(secondLevel);
//            obj.setFirstLevel(firstLevel);
//            postgreRepository.save(obj);
//        }
//        return "Update successful";
//    }
}
