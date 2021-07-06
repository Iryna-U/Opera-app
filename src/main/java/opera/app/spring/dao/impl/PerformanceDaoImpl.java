package opera.app.spring.dao.impl;

import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.PerformanceDao;
import opera.app.spring.model.Performance;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
