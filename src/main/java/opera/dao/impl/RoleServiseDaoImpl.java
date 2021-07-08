package opera.dao.impl;

import opera.dao.AbstractDao;
import opera.dao.RoleServiseDao;
import opera.exception.DataProcessingException;
import opera.model.Role;
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
