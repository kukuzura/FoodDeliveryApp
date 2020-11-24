package yurusova.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
			joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	private List<Role> roles;

	private String username;
	private String password;

	@OneToOne
	private User admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
