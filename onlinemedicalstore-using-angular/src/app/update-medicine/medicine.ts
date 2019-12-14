export class Medicine {
    constructor(
        // tslint:disable-next-line: variable-name
        public productId: number,
        // tslint:disable-next-line: variable-name
        public productName: string,
        // tslint:disable-next-line: variable-name
        public price: number,
        public category: string,
        public available: string
    ) { }
}
