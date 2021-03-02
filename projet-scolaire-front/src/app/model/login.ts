import { ResolveStart } from "@angular/router";
import { Roles } from "./roles.enum";

export class Login {
  protected _login: string;
  private _password: string;
  private roles : string;

  constructor(login: string = '', password: string = '', roles: string='') {
    this._login = login;
    this._password = password;
    this.roles= roles;
    }

    /**
    * Getter username
    * @return {string}
    */
    public get login(): string {
    return this._login;
    }

    /**
    * Getter password
    * @return {string}
    */
    public get password(): string {
    return this._password;
    }

    /**
    * Setter username
    * @param {string} value
    */
    public set username(value: string) {
    this._login = value;
    }

    /**
    * Setter password
    * @param {string} value
    */
    public set password(value: string) {
    this._password = value;
    }

    /**
     * Getter $roles
     * @return {string}
     */
	public get $roles(): string {
		return this.roles;
	}

    /**
     * Setter $roles
     * @param {string} value
     */
	public set $roles(value: string) {
		this.roles = value;
	}




}
