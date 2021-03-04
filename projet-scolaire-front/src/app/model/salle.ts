export class Salle {

  private _id: number;
  private _nom: string;
  private _capacite: number;

  constructor(id?: number , nom:string = '', capacite: number = 0) {

    this._id = id;
    this._nom = nom;
    this._capacite = capacite;
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
     * Getter capacite
     * @return {number}
     */
	public get capacite(): number {
		return this._capacite;
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
     * Setter capacite
     * @param {number} value
     */
	public set capacite(value: number) {
		this._capacite = value;
	}


}
