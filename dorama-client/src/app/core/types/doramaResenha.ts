import { Resenha } from "./resenha"

export interface DoramaResenha {
    id: number
    titulo: string
    descricao: string
    genero: string
    anoDeLancamento: number
    imagem: string
    resenhas: Resenha[]
}