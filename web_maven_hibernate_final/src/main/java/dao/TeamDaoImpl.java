package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<String> getAllAbbreviations() {
		List<String> abbreviations = null;
		String jpql = "select t.abbreviation from Team t";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			abbreviations = session.createQuery(jpql, String.class)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return abbreviations;
	}

}
