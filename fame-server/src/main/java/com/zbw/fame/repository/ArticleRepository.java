package com.zbw.fame.repository;

import com.zbw.fame.model.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangbowen
 * @since 2019/6/24 10:14
 */
public interface ArticleRepository<ARTICLE extends Article> extends JpaRepository<ARTICLE, Integer>, JpaSpecificationExecutor<ARTICLE> {

    /**
     * 根据id和状态查询文章
     *
     * @param id     id
     * @param status 状态
     * @return Optional<ARTICLE>
     */
    Optional<ARTICLE> findByIdAndStatus(Integer id, String status);

    /**
     * 根据状态和类型查询文章
     *
     * @param status 状态
     * @return List<ARTICLE>
     */
    List<ARTICLE> findAllByStatusOrderByIdDesc(String status);

    /**
     * 根据状态分页查询文章
     *
     * @param status   状态
     * @param pageable 分页
     * @return Page<ARTICLE>
     */
    Page<ARTICLE> findAllByStatus(String status, Pageable pageable);

    /**
     * 根据状态和类型查询文章
     *
     * @param notStatus 不属于的状态
     * @return List<ARTICLE>
     */
    List<ARTICLE> findAllByStatusNotOrderByIdDesc(String notStatus);

    /**
     * 根据状态计数
     *
     * @param notStatus 状态
     * @return count
     */
    int countByStatusNot(String notStatus);

}