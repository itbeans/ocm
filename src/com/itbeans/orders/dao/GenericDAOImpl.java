package com.itbeans.orders.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.eclipse.persistence.sessions.Session;

public abstract class GenericDAOImpl<T, ID extends Serializable>
    implements GenericDAO<T, ID> {

private Class<T> persistentClass;
private Session session;

@SuppressWarnings("unchecked")
public GenericDAOImpl() {
    this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[0];
 }

@SuppressWarnings("unchecked")
public void setSession(Session s) {
    this.session = s;
}

protected Session getSession() {
    if (session == null)
        throw new IllegalStateException("Session has not been set on DAO before usage");
    return session;
}

public Class<T> getPersistentClass() {
    return persistentClass;
}
/*
@SuppressWarnings("unchecked")
public T findById(ID id, boolean lock) {
    T entity;
    if (lock)
        entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
    else
        entity = (T) getSession().load(getPersistentClass(), id);

    return entity;
}

@SuppressWarnings("unchecked")
public List<T> findAll() {
    return findByCriteria();
}

@SuppressWarnings("unchecked")
public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    Example example =  Example.create(exampleInstance);
    for (String exclude : excludeProperty) {
        example.excludeProperty(exclude);
    }
    crit.add(example);
    return crit.list();
}

@SuppressWarnings("unchecked")
public T makePersistent(T entity) {
    getSession().saveOrUpdate(entity);
    return entity;
}

public void makeTransient(T entity) {
    getSession().delete(entity);
}

public void flush() {
    getSession().flush();
}

public void clear() {
    getSession().clear();
}

/**
 * Use this inside subclasses as a convenience method.
 */
/*
@SuppressWarnings("unchecked")
protected List<T> findByCriteria(Criterion... criterion) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    for (Criterion c : criterion) {
        crit.add(c);
    }
    return crit.list();
}
*/
}

