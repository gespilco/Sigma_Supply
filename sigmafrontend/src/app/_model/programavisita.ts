export class ProgramaVisita {
    public id_programa_visita: number;
    public acepta_cliente:Boolean;
    public acepta_tecnico:Boolean;
    public activo:Boolean;
    public codigo_visita:string;
    public descripcion:string;
    public fecha_creacion:Date;
    public fecha_eliminacion:Date;
    public fecha_modificacion:Date;
    public fecha_programada:Date;
    public fecha_visita:Date;
    public observacion:string;
    public programacion:string;
    public usuario_creacion:number;
    public usuario_eliminacion:number;
    public usuario_modificacion:number;
}