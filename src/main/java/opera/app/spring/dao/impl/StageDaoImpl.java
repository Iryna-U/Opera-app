package opera.app.spring.dao.impl;

import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.StageDao;
import opera.app.spring.model.Stage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}
