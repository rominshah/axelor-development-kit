/**
 * Copyright (c) 2012-2014 Axelor. All Rights Reserved.
 *
 * The contents of this file are subject to the Common Public
 * Attribution License Version 1.0 (the “License”); you may not use
 * this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://license.axelor.com/.
 *
 * The License is based on the Mozilla Public License Version 1.1 but
 * Sections 14 and 15 have been added to cover use of software over a
 * computer network and provide for limited attribution for the
 * Original Developer. In addition, Exhibit A has been modified to be
 * consistent with Exhibit B.
 *
 * Software distributed under the License is distributed on an “AS IS”
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is part of "Axelor Business Suite", developed by
 * Axelor exclusively.
 *
 * The Original Developer is the Initial Developer. The Initial Developer of
 * the Original Code is Axelor.
 *
 * All portions of the code written by Axelor are
 * Copyright (c) 2012-2014 Axelor. All Rights Reserved.
 */
package com.axelor.test.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.axelor.db.JPA;
import com.axelor.db.Model;
import com.axelor.db.Query;
import com.axelor.db.internal.EntityHelper;

@Entity
@Table(name = "CONTACT_CIRCLE")
public class Circle extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_CIRCLE_SEQ")
	@SequenceGenerator(name = "CONTACT_CIRCLE_SEQ", sequenceName = "CONTACT_CIRCLE_SEQ", allocationSize = 1)
	private Long id;
	
	@NotNull
	private String code;

	@NotNull
	private String name;

	public Circle() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Circle(String name, String title) {
		this.code = name;
		this.name = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String name) {
		this.code = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String title) {
		this.name = title;
	}
	
	@Override
	public String toString() {
		return EntityHelper.toString(this);
	}
	
	public static Query<Circle> all() {
		return JPA.all(Circle.class);
	}

}