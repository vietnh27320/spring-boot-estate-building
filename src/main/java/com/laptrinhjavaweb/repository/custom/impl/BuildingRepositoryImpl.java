package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findByStaff(Long staffId) {
        /*sql native*/
        StringBuilder sql = new StringBuilder("select * from building as b");
        sql.append(" inner join assignmentbuilding as a on b.id = a.buildingid");
        sql.append(" where a.staffid = " + staffId + "");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, Map<String, Object> params) {
        StringBuilder sql = new StringBuilder("FROM BuildingEntity A WHERE 1 = 1");
        sql = this.createSqlCommon(sql, params);
        Query query = entityManager.createQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder createSqlCommon(StringBuilder where, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            String[] keys = new String[params.size()];
            Object[] values = new Object[params.size()];
            int i = 0;
            for (Map.Entry<String, Object> item : params.entrySet()) {
                keys[i] = item.getKey();
                values[i] = item.getValue();
                i++;
            }
            for (int j = 0; j < keys.length; j++) {
                if ((values[j] instanceof String) && (StringUtils.isNotBlank(values[j].toString()))) {
                    where.append(" and A." + keys[j] + " like '%" + values[j] + "%'");
                } else if ((values[j] instanceof Integer) && (values[j] != null)) {
                    where.append(" and A." + keys[j] + " = " + values[j] + "");
                }
            }
        }
        return where;
    }
}

