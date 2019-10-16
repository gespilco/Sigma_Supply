import { OrdenServicio } from './orden-servicio';
import { Visita } from './visita';

export class Programacion {
    public idProgramacion: number;
    public aceptaCliente: Boolean;
    public aceptaTecnico: Boolean;
    public activo: Boolean;
    public fechaCreacion: Date;
    public fechaEliminacion: Date;
    public fechaModificacion: Date;
    public fechaProgramada: Date;
    public programacion: string;
    public usuarioCreacion: number;
    public usuarioEliminacion: number;
    public usuarioModificacion: number;
    public ordenServicio: OrdenServicio;
    public visita: Visita;
}