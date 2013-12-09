/*  This file is part of Waisda 

    Copyright (c) 2012 Netherlands Institute for Sound and Vision
    https://github.com/beeldengeluid/waisda
	
    Waisda is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Waisda is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Waisda.  If not, see <http://www.gnu.org/licenses/>.
*/

package nl.waisda.forms;

import java.util.Date;

import nl.waisda.domain.Gender;
import nl.waisda.domain.User;


public class ProfileForm implements ApplyForm<User>, FillForm<User> {

	private AuthForm auth = new AuthForm();

	private int id;
	private String dateOfBirth;
	private Date formattedDateOfBirth;
	private Gender gender;

	private String usernameTwitter;
	private String usernameHyves;
	private String usernameFacebook;
	
	private String currentPassword;

	public AuthForm getAuth() {
		return auth;
	}

	public void setAuth(AuthForm auth) {
		this.auth = auth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getFormattedDateOfBirth() {
		return formattedDateOfBirth;
	}

	public void setFormattedDateOfBirth(Date formattedDateOfBirth) {
		this.formattedDateOfBirth = formattedDateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getUsernameTwitter() {
		return usernameTwitter;
	}

	public void setUsernameTwitter(String usernameTwitter) {
		this.usernameTwitter = usernameTwitter;
	}

	public String getUsernameHyves() {
		return usernameHyves;
	}

	public void setUsernameHyves(String usernameHyves) {
		this.usernameHyves = usernameHyves;
	}

	public String getUsernameFacebook() {
		return usernameFacebook;
	}

	public void setUsernameFacebook(String usernameFacebook) {
		this.usernameFacebook = usernameFacebook;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public void applyTo(User user) {
		auth.applyTo(user);
		user.setDateOfBirth(formattedDateOfBirth);
		user.setGender(gender);
		user.setUsernameTwitter(usernameTwitter);
		user.setUsernameHyves(usernameHyves);
		user.setUsernameFacebook(usernameFacebook);
	}

	@Override
	public void fillFrom(User user) {
		auth.fillFrom(user);
		Date date = user.getDateOfBirth();
		dateOfBirth = date != null ? User.DATE_FORMAT.format(date) : null;
		id = user.getId();
		gender = user.getGender();
		usernameTwitter = user.getUsernameTwitter();
		usernameHyves = user.getUsernameHyves();
		usernameFacebook = user.getUsernameFacebook();
	}

}
