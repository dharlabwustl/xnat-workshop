package org.nrg.xnat.workshop2016.services.impl;

import org.nrg.framework.orm.hibernate.AbstractHibernateEntityService;
import org.nrg.xnat.workshop2016.entities.SubjectMapping;
import org.nrg.xnat.workshop2016.repositories.SubjectMappingRepository;
import org.nrg.xnat.workshop2016.services.SubjectMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HibernateSubjectMappingService extends AbstractHibernateEntityService<SubjectMapping, SubjectMappingRepository> implements SubjectMappingService {
    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SubjectMapping findBySubjectId(final String subjectId) {
        return getDao().findByUniqueProperty("subjectId", subjectId);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public SubjectMapping findByRecordId(final String recordId, final String source) {
        final Map<String, Object> properties = new HashMap<>();
        properties.put("recordId", recordId);
        properties.put("source", source);
        final List<SubjectMapping> subjectMappings = getDao().findByProperties(properties);
        if (subjectMappings == null || subjectMappings.size() == 0) {
            return null;
        }
        return subjectMappings.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<SubjectMapping> findBySource(final String source) {
        return getDao().findByProperty("source", source);
    }
}
