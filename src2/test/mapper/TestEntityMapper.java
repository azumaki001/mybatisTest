package test.mapper;

import test.entity.TestEntity;

public interface TestEntityMapper {

	TestEntity selectById (Integer id);

	void insertAll (TestEntity te);

}
