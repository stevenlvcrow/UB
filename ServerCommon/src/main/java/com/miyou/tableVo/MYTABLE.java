package com.miyou.tableVo;

import javax.persistence.*;

@Entity
@Table(name = "MYTABLE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteTestCase", procedureName = "deleteTestCase", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam2", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam3", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam4", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)})
        })
public class MYTABLE {

    @Id
    private String id;
}
