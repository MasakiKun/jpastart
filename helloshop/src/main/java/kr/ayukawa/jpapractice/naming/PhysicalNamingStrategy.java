package kr.ayukawa.jpapractice.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/*
 하이버네이트 5 부터는 캐멀 케이스를 스네이크 케이스로 자동 변환해주는 hibernate.ejb.naming_strategy 설정이 사라지고
 이 설정에서 사용하던 org.hibernate.cfg.ImprovedNamingStrategy 클래스도 사라졌다.
 하이버네이트 5 에서는 다른 설정에, 직접 구현한 네이밍 전략 클래스를 작성해서 사용해야 한다.
 이 클래스는 (아마도 캐멀 케이스로 작성되었을) 논리명칭을 스네이크 케이스의 물리명으로 변환해준다. (테스트 못해봄-_-)
 해당 클래스 출처: https://stackoverflow.com/a/34565182
*/
public class PhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
		return converter(name);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return converter(name);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return converter(name);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
		return converter(name);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
		return converter(name);
	}

	private Identifier converter(Identifier identifier) {
		if(identifier == null || identifier.getText().isBlank())
			return identifier;

		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";
		String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();
		return Identifier.toIdentifier(newName);
	}
}
