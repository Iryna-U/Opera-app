package opera.app.spring.dao.impl;

import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.RoleServiseDao;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleServiseDaoImpl extends AbstractDao<Role> implements RoleServiseDao {

    public RoleServiseDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> query = session.createQuery("FROM Role "
                    + "WHERE roleName =: roleName", Role.class);
            query.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException(" помилка в getRoleByName ", e);
        }
    }
}
