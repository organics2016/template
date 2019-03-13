package ink.organics.openjdk11.application;


import ink.organics.openjdk11.dto.DemoSearchDTO;
import ink.organics.openjdk11.dto.PageResponseDTO;
import ink.organics.openjdk11.model.Demo;
import ink.organics.openjdk11.repository.DemoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class DemoService {


    @Resource
    private DemoRepository demoRepository;


    public void add(String name) {
        Demo demo = new Demo();
        demo.setName(name);
        demoRepository.save(demo);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PageResponseDTO getDemoPage(DemoSearchDTO dto) {

        Page<Demo> page = demoRepository.findAll(((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            String queryInfo = dto.getQueryInfo();

            if (StringUtils.isNotBlank(queryInfo)) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + queryInfo + "%"));
            }

            return query.where(predicates.toArray(new Predicate[0]))
                    .getRestriction();
        }), PageRequest.of(dto.getPage(), dto.getSize(), Sort.by(Sort.Direction.DESC, "createdDate")));

        PageResponseDTO<Demo> dtos = new PageResponseDTO<>();

        dtos.setContent(page.getContent());
        dtos.setTotalElements(page.getTotalElements());
        dtos.setTotalPages(page.getTotalPages());

        return dtos;
    }
}
