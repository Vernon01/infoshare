package infoshare.services.people;

import infoshare.domain.person.PersonContact;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by user9 on 2016/03/02.
 */
@Component
public interface PersonContactService {
    PersonContact save(PersonContact entity);
    PersonContact update(PersonContact entity);
    void delete(PersonContact entity);
    PersonContact findById(String personId,String id);
    Set<PersonContact> findAll(String personId);
}
