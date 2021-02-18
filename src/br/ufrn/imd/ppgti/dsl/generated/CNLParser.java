// Generated from D:/Dropbox/IMD/Mestrado Profissional/2020.2/Disciplinas/PPGTI1007 - LINGUAGENS DE DOMÍNIO ESPECÍFICO - T01/Projetos Atividades/code/CNL/src/br/ufrn/imd/ppgti/dsl\CNL.g4 by ANTLR 4.9.1
package br.ufrn.imd.ppgti.dsl.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CNLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, FUNCAO=27, CPF=28, TEMPERATURA=29, DOUBLE=30, PERCENTUAL=31, 
		DOSE=32, DATA=33, DATAHORA=34, NUMERO=35, DOISNUMEROS=36, TRESNUMEROS=37, 
		QUATRONUMEROS=38, NUMEROS=39, ONZENUMEROS=40, COMORBIDADE=41, TIPOEXAME=42, 
		TIPOSINAL=43, TIPOSINTOMA=44, TIPOVACINA=45, RESULTADO=46, DIAGNOSTICO=47, 
		NIVEL=48, NOME=49, SERIAL=50, WHITESPACE=51;
	public static final int
		RULE_start = 0, RULE_comando = 1, RULE_obj = 2, RULE_par = 3, RULE_temporal = 4, 
		RULE_lista = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "comando", "obj", "par", "temporal", "lista"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+'", "'{'", "','", "'}'", "'nome'", "':'", "'cpf'", "'nascimento'", 
			"'tipo'", "'leitura'", "'data'", "'resultado'", "'diagnostico'", "'igm'", 
			"'igg'", "'dose'", "'lote'", "'serial'", "'comorbidades'", "'sinais'", 
			"'sintomas'", "'exames'", "'vacinas'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "FUNCAO", "CPF", "TEMPERATURA", "DOUBLE", "PERCENTUAL", 
			"DOSE", "DATA", "DATAHORA", "NUMERO", "DOISNUMEROS", "TRESNUMEROS", "QUATRONUMEROS", 
			"NUMEROS", "ONZENUMEROS", "COMORBIDADE", "TIPOEXAME", "TIPOSINAL", "TIPOSINTOMA", 
			"TIPOVACINA", "RESULTADO", "DIAGNOSTICO", "NIVEL", "NOME", "SERIAL", 
			"WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CNL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CNLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CNLParser.EOF, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				comando();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << FUNCAO) | (1L << COMORBIDADE) | (1L << NOME))) != 0) );
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	 
		public ComandoContext() { }
		public void copyFrom(ComandoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConcatContext extends ComandoContext {
		public List<ObjContext> obj() {
			return getRuleContexts(ObjContext.class);
		}
		public ObjContext obj(int i) {
			return getRuleContext(ObjContext.class,i);
		}
		public List<TerminalNode> NOME() { return getTokens(CNLParser.NOME); }
		public TerminalNode NOME(int i) {
			return getToken(CNLParser.NOME, i);
		}
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ConcatContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttribConcatContext extends ComandoContext {
		public TerminalNode NOME() { return getToken(CNLParser.NOME, 0); }
		public List<ObjContext> obj() {
			return getRuleContexts(ObjContext.class);
		}
		public ObjContext obj(int i) {
			return getRuleContext(ObjContext.class,i);
		}
		public List<ListaContext> lista() {
			return getRuleContexts(ListaContext.class);
		}
		public ListaContext lista(int i) {
			return getRuleContext(ListaContext.class,i);
		}
		public AttribConcatContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterAttribConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitAttribConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitAttribConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodContext extends ComandoContext {
		public TerminalNode FUNCAO() { return getToken(CNLParser.FUNCAO, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public TerminalNode NOME() { return getToken(CNLParser.NOME, 0); }
		public TerminalNode DATA() { return getToken(CNLParser.DATA, 0); }
		public TerminalNode DATAHORA() { return getToken(CNLParser.DATAHORA, 0); }
		public MethodContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttribContext extends ComandoContext {
		public TerminalNode NOME() { return getToken(CNLParser.NOME, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public AttribContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitAttrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitAttrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comando);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AttribContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(NOME);
				setState(20);
				match(T__0);
				setState(23);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case COMORBIDADE:
					{
					setState(21);
					obj();
					}
					break;
				case T__24:
					{
					setState(22);
					lista();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new ConcatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case COMORBIDADE:
					{
					setState(25);
					obj();
					}
					break;
				case NOME:
					{
					setState(26);
					match(NOME);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(29);
				match(T__1);
				setState(33);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case COMORBIDADE:
					{
					setState(30);
					obj();
					}
					break;
				case NOME:
					{
					setState(31);
					match(NOME);
					}
					break;
				case T__24:
					{
					setState(32);
					lista();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new MethodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(FUNCAO);
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case COMORBIDADE:
					{
					setState(36);
					obj();
					}
					break;
				case NOME:
					{
					setState(37);
					match(NOME);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATA || _la==DATAHORA) {
					{
					setState(40);
					_la = _input.LA(1);
					if ( !(_la==DATA || _la==DATAHORA) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 4:
				_localctx = new AttribConcatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(NOME);
				setState(44);
				match(T__0);
				setState(47);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case COMORBIDADE:
					{
					setState(45);
					obj();
					}
					break;
				case T__24:
					{
					setState(46);
					lista();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(49);
					match(T__1);
					setState(52);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__2:
					case COMORBIDADE:
						{
						setState(50);
						obj();
						}
						break;
					case T__24:
						{
						setState(51);
						lista();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjContext extends ParserRuleContext {
		public List<ParContext> par() {
			return getRuleContexts(ParContext.class);
		}
		public ParContext par(int i) {
			return getRuleContext(ParContext.class,i);
		}
		public TerminalNode COMORBIDADE() { return getToken(CNLParser.COMORBIDADE, 0); }
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_obj);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__2);
				setState(62);
				par();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(63);
					match(T__3);
					setState(64);
					par();
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(70);
				match(T__4);
				}
				break;
			case COMORBIDADE:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(COMORBIDADE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParContext extends ParserRuleContext {
		public TerminalNode NOME() { return getToken(CNLParser.NOME, 0); }
		public TerminalNode CPF() { return getToken(CNLParser.CPF, 0); }
		public TerminalNode DATA() { return getToken(CNLParser.DATA, 0); }
		public TerminalNode TIPOEXAME() { return getToken(CNLParser.TIPOEXAME, 0); }
		public TerminalNode TIPOSINAL() { return getToken(CNLParser.TIPOSINAL, 0); }
		public TerminalNode TIPOSINTOMA() { return getToken(CNLParser.TIPOSINTOMA, 0); }
		public TerminalNode TIPOVACINA() { return getToken(CNLParser.TIPOVACINA, 0); }
		public TerminalNode TEMPERATURA() { return getToken(CNLParser.TEMPERATURA, 0); }
		public TerminalNode PERCENTUAL() { return getToken(CNLParser.PERCENTUAL, 0); }
		public TerminalNode DATAHORA() { return getToken(CNLParser.DATAHORA, 0); }
		public TerminalNode RESULTADO() { return getToken(CNLParser.RESULTADO, 0); }
		public TerminalNode DIAGNOSTICO() { return getToken(CNLParser.DIAGNOSTICO, 0); }
		public TerminalNode DOUBLE() { return getToken(CNLParser.DOUBLE, 0); }
		public TerminalNode DOSE() { return getToken(CNLParser.DOSE, 0); }
		public TerminalNode SERIAL() { return getToken(CNLParser.SERIAL, 0); }
		public TemporalContext temporal() {
			return getRuleContext(TemporalContext.class,0);
		}
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public ParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_par; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParContext par() throws RecognitionException {
		ParContext _localctx = new ParContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_par);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__5);
				setState(76);
				match(T__6);
				setState(77);
				match(NOME);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(T__7);
				setState(79);
				match(T__6);
				setState(80);
				match(CPF);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(T__8);
				setState(82);
				match(T__6);
				setState(83);
				match(DATA);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				match(T__9);
				setState(85);
				match(T__6);
				setState(86);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIPOEXAME) | (1L << TIPOSINAL) | (1L << TIPOSINTOMA) | (1L << TIPOVACINA))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(T__10);
				setState(88);
				match(T__6);
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==TEMPERATURA || _la==PERCENTUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				match(T__11);
				setState(91);
				match(T__6);
				setState(92);
				match(DATAHORA);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				match(T__12);
				setState(94);
				match(T__6);
				setState(95);
				match(RESULTADO);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				match(T__13);
				setState(97);
				match(T__6);
				setState(98);
				match(DIAGNOSTICO);
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 9);
				{
				setState(103);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(99);
					match(T__14);
					setState(100);
					match(T__6);
					}
					break;
				case T__15:
					{
					setState(101);
					match(T__15);
					setState(102);
					match(T__6);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(105);
				match(DOUBLE);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 10);
				{
				setState(106);
				match(T__16);
				setState(107);
				match(T__6);
				setState(108);
				match(DOSE);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 11);
				{
				setState(109);
				match(T__17);
				setState(110);
				match(T__6);
				setState(111);
				match(SERIAL);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 12);
				{
				setState(112);
				match(T__18);
				setState(113);
				match(T__6);
				setState(114);
				match(SERIAL);
				}
				break;
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 13);
				{
				setState(115);
				temporal();
				setState(116);
				match(T__6);
				setState(117);
				lista();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalContext extends ParserRuleContext {
		public TemporalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterTemporal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitTemporal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitTemporal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalContext temporal() throws RecognitionException {
		TemporalContext _localctx = new TemporalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_temporal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaContext extends ParserRuleContext {
		public List<ObjContext> obj() {
			return getRuleContexts(ObjContext.class);
		}
		public ObjContext obj(int i) {
			return getRuleContext(ObjContext.class,i);
		}
		public ListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).enterLista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CNLListener ) ((CNLListener)listener).exitLista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CNLVisitor ) return ((CNLVisitor<? extends T>)visitor).visitLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaContext lista() throws RecognitionException {
		ListaContext _localctx = new ListaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__24);
			setState(124);
			obj();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(125);
				match(T__3);
				setState(126);
				obj();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u0089\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\5\3\36\n\3\3\3\3\3\3\3\3\3\5"+
		"\3$\n\3\3\3\3\3\3\3\5\3)\n\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\3\3\3\3\3\5\3\67\n\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\4\3\4\3\4\3\4"+
		"\7\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5j\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5z\n\5\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u0082\n\7\f\7\16\7"+
		"\u0085\13\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\6\3\2#$\3\2,/\4\2\37\37!!"+
		"\3\2\26\32\2\u009f\2\17\3\2\2\2\4=\3\2\2\2\6K\3\2\2\2\by\3\2\2\2\n{\3"+
		"\2\2\2\f}\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2"+
		"\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\7\63"+
		"\2\2\26\31\7\3\2\2\27\32\5\6\4\2\30\32\5\f\7\2\31\27\3\2\2\2\31\30\3\2"+
		"\2\2\32>\3\2\2\2\33\36\5\6\4\2\34\36\7\63\2\2\35\33\3\2\2\2\35\34\3\2"+
		"\2\2\36\37\3\2\2\2\37#\7\4\2\2 $\5\6\4\2!$\7\63\2\2\"$\5\f\7\2# \3\2\2"+
		"\2#!\3\2\2\2#\"\3\2\2\2$>\3\2\2\2%(\7\35\2\2&)\5\6\4\2\')\7\63\2\2(&\3"+
		"\2\2\2(\'\3\2\2\2)+\3\2\2\2*,\t\2\2\2+*\3\2\2\2+,\3\2\2\2,>\3\2\2\2-."+
		"\7\63\2\2.\61\7\3\2\2/\62\5\6\4\2\60\62\5\f\7\2\61/\3\2\2\2\61\60\3\2"+
		"\2\2\62:\3\2\2\2\63\66\7\4\2\2\64\67\5\6\4\2\65\67\5\f\7\2\66\64\3\2\2"+
		"\2\66\65\3\2\2\2\679\3\2\2\28\63\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2"+
		";>\3\2\2\2<:\3\2\2\2=\25\3\2\2\2=\35\3\2\2\2=%\3\2\2\2=-\3\2\2\2>\5\3"+
		"\2\2\2?@\7\5\2\2@E\5\b\5\2AB\7\6\2\2BD\5\b\5\2CA\3\2\2\2DG\3\2\2\2EC\3"+
		"\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\7\2\2IL\3\2\2\2JL\7+\2\2K?\3"+
		"\2\2\2KJ\3\2\2\2L\7\3\2\2\2MN\7\b\2\2NO\7\t\2\2Oz\7\63\2\2PQ\7\n\2\2Q"+
		"R\7\t\2\2Rz\7\36\2\2ST\7\13\2\2TU\7\t\2\2Uz\7#\2\2VW\7\f\2\2WX\7\t\2\2"+
		"Xz\t\3\2\2YZ\7\r\2\2Z[\7\t\2\2[z\t\4\2\2\\]\7\16\2\2]^\7\t\2\2^z\7$\2"+
		"\2_`\7\17\2\2`a\7\t\2\2az\7\60\2\2bc\7\20\2\2cd\7\t\2\2dz\7\61\2\2ef\7"+
		"\21\2\2fj\7\t\2\2gh\7\22\2\2hj\7\t\2\2ie\3\2\2\2ig\3\2\2\2jk\3\2\2\2k"+
		"z\7 \2\2lm\7\23\2\2mn\7\t\2\2nz\7\"\2\2op\7\24\2\2pq\7\t\2\2qz\7\64\2"+
		"\2rs\7\25\2\2st\7\t\2\2tz\7\64\2\2uv\5\n\6\2vw\7\t\2\2wx\5\f\7\2xz\3\2"+
		"\2\2yM\3\2\2\2yP\3\2\2\2yS\3\2\2\2yV\3\2\2\2yY\3\2\2\2y\\\3\2\2\2y_\3"+
		"\2\2\2yb\3\2\2\2yi\3\2\2\2yl\3\2\2\2yo\3\2\2\2yr\3\2\2\2yu\3\2\2\2z\t"+
		"\3\2\2\2{|\t\5\2\2|\13\3\2\2\2}~\7\33\2\2~\u0083\5\6\4\2\177\u0080\7\6"+
		"\2\2\u0080\u0082\5\6\4\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\7\34\2\2\u0087\r\3\2\2\2\21\21\31\35#(+\61\66:=EKiy\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}