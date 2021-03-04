export class Classe {

  private _id:number;
  private _nom: string;
  private _profPrincipal: string;


	constructor(id?: number, nom: string='', profPrincipal: string='') {
		this._id = id;
		this._nom = nom;
		this._profPrincipal = profPrincipal;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}

    /**
     * Getter profPrincipal
     * @return {string}
     */
	public get profPrincipal(): string {
		return this._profPrincipal;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}

    /**
     * Setter profPrincipal
     * @param {string} value
     */
	public set profPrincipal(value: string) {
		this._profPrincipal = value;
	}

}
