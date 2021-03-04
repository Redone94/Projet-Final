import { ListMatieresComponent } from "../matieres/list-matieres/list-matieres.component";
import { Adresse } from "./adresse";
import { Compte } from "./compte";

export class Professeur {
    private _id: number;
    private _nom: string;
    private _prenom: string;
    private _datenaissance: Date;
    private _adresse: Adresse;
    private _compte: Compte;

    private _matiere: ListMatieresComponent;

    private _logo:symbol;


	constructor(id?: number,nom: string='', prenom: string='', datenaissance?:Date, adresse?: Adresse, compte?: Compte, matiere?: ListMatieresComponent, logo?: symbol) {
		this._id=id;
        this._nom = nom;
		this._prenom = prenom;
		this._adresse = adresse;
		this._compte = compte;
		this._matiere = matiere;
		// this._cours = cours;
		this._logo = logo;
        this._datenaissance = datenaissance;
        this._adresse=adresse;
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
     * Getter prenom
     * @return {string}
     */
	public get prenom(): string {
		return this._prenom;
	}

    /**
     * Getter datenaissance
     * @return {Date}
     */
	public get datenaissance(): Date {
		return this._datenaissance;
	}

    /**
     * Getter adresse
     * @return {Adresse}
     */
	public get adresse(): Adresse {
		return this._adresse;
	}

    /**
     * Getter compte
     * @return {Compte}
     */
	public get compte(): Compte {
		return this._compte;
	}

    /**
     * Getter matiere
     * @return {ListMatieresComponent}
     */
	public get matiere(): ListMatieresComponent {
		return this._matiere;
	}

    /**
     * Getter logo
     * @return {symbol}
     */
	public get logo(): symbol {
		return this._logo;
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
     * Setter prenom
     * @param {string} value
     */
	public set prenom(value: string) {
		this._prenom = value;
	}

    /**
     * Setter datenaissance
     * @param {Date} value
     */
	public set datenaissance(value: Date) {
		this._datenaissance = value;
	}

    /**
     * Setter adresse
     * @param {Adresse} value
     */
	public set adresse(value: Adresse) {
		this._adresse = value;
	}

    /**
     * Setter compte
     * @param {Compte} value
     */
	public set compte(value: Compte) {
		this._compte = value;
	}

    /**
     * Setter matiere
     * @param {ListMatieresComponent} value
     */
	public set matiere(value: ListMatieresComponent) {
		this._matiere = value;
	}

    /**
     * Setter logo
     * @param {symbol} value
     */
	public set logo(value: symbol) {
		this._logo = value;
	}

}
