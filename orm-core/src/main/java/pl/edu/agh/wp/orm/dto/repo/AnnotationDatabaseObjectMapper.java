package pl.edu.agh.wp.orm.dto.repo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import pl.ed.agh.wp.orm.annotations.DBTable;
import pl.edu.agh.wp.orm.dto.DBTableObject;
import pl.edu.agh.wp.orm.exception.ORMException;
import pl.edu.agh.wp.orm.mapper.TableMapper;

public class AnnotationDatabaseObjectMapper implements DatabaseObjectMapper {

    private ClassPathScanningCandidateComponentProvider scanner;
    private TableMapper mapper;
    private String basePackage;

    public AnnotationDatabaseObjectMapper(String basePackage,TableMapper mapper) {
        this.basePackage = basePackage;
        this.mapper = mapper;
        scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(DBTable.class));
    }
    
    @Override
    public EntitiesRepository getEntitiesRepository()  {
        EntitiesRepository entities =  EntitiesRepository.getInstance();
        for(BeanDefinition bean :scanner.findCandidateComponents(basePackage)){
            Class clazz  = null;
            try {
                clazz = Class.forName(bean.getBeanClassName());
            } catch (ClassNotFoundException e) {
                throw new ORMException("Class not found",e);
            }
            DBTableObject table = mapper.getTable(clazz);
            entities.addEntity(table);
      }
      return entities;

    }
}
