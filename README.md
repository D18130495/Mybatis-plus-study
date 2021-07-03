# Mybatis-plus
Official website: https://baomidou.com/
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

### Locker
- Pessimistic lock(Serial)
- Optimistic lock(version) Grab tickets
pojo
``` java
    @Version
    private Integer version;
```
config
``` java
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
```

### Limit(Pagination)
config
``` java
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
```

``` java
    void limit() {
        Page<User> page = new Page<User>(1, 3);
        userMapper.selectPage(page, null);

        page.getCurrent();//current page
        page.getRecords();//all data
        page.getSize();//how many data per page
        page.getTotal();//number of total records
        page.getPages();//number of total pages

        page.hasNext();//if has next page
        page.hasPrevious();//if has next page
    }
```

###
pojo(must use deleted)
``` java
    @TableLogic
    private Integer deleted;
```
config
``` java
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
```
