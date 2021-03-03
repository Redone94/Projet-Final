import { Etablissement } from "./etablissement";
import { Roles } from "./roles.enum";

export class Compte {

    private _id: number;
    private _login: string;
    private _password: string;
    role: Roles;
    etablissement: Etablissement;


	constructor(id?: number, login: string='', password: string='',role?:Roles, etablissement?:Etablissement) {
		this._id = id;
		this._login = login;
		this._password = password;
        this.role = role;
        this.etablissement= etablissement;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter login
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
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter login
     * @param {string} value
     */
	public set login(value: string) {
		this._login = value;
	}

    /**
     * Setter password
     * @param {string} value
     */
	public set password(value: string) {
		this._password = value;
	}


    
}
