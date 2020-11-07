package yurusova.service;

import org.springframework.stereotype.Service;
import yurusova.entity.Role;
import yurusova.repository.RoleRepository;

import javax.annotation.Resource;

@Service
public class RoleService
{
	@Resource
	private RoleRepository roleRepository;

	public Role getRoleByName(String roleName)
	{
		return roleRepository.findRoleByName(roleName);
	}
}
