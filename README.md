# Mybatis-plus
Official website: https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core
### Primary key
- AUTO INCREMENT @TableId(type = IdType.AUTO)
- UUID @TableId(type = IdType.UUID)
- Redis
- mp snowflake(default) @TableId(type = IdType.ID_WORKER) @TableId(type = IdType.ID_WORKER_STR)

### Auto fill
``` java
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
```

File under handler
``` java
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
```

### Lock
- Pessimistic lock(Serial)
- Optimistic lock(version) Grab tickets
