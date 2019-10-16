package pe.sigma.util;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL95Dialect;

import com.fasterxml.jackson.databind.node.JsonNodeType;

public class PostgreSQL95JsonDialect extends PostgreSQL95Dialect {
	public PostgreSQL95JsonDialect() {
        super();
        this.registerHibernateType(
            Types.OTHER, JsonNodeType.class.getName()
        );
    }
}
