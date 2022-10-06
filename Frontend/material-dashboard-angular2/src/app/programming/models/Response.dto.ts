export class Response<T>{

    code: string;
    body: T;
    message: string;

    constructor(){}
}