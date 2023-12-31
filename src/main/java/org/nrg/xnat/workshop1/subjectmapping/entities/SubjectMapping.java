/*
 * xnat-workshop: org.nrg.xnat.workshop.subjectmapping.entities.SubjectMapping
 * XNAT http://www.xnat.org
 * Copyright (c) 2017, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.workshop1.subjectmapping.entities;

import org.nrg.framework.orm.hibernate.AbstractHibernateEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "subjectId"), @UniqueConstraint(columnNames = {"recordId", "source"})})
public class SubjectMapping extends AbstractHibernateEntity {
    public String getSubjectId() {
        return _subjectId;
    }

    public void setSubjectId(final String subjectId) {
        _subjectId = subjectId;
    }

    public String getRecordId() {
        return _recordId;
    }

    public void setRecordId(final String recordId) {
        _recordId = recordId;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(final String source) {
        _source = source;
    }

    private String _subjectId;
    private String _recordId;
    private String _source;
}
