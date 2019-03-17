GRAMMARS := $(shell ls *.g4)

MAIN_CLASS := $(subst .g4,Main.class,$(GRAMMARS))
LEXER_CLASS := $(subst .g4,Lexer.class,$(GRAMMARS))
PARSER_CLASS := $(subst .g4,Parser.class,$(GRAMMARS))
LISTENER_CLASS := $(subst .g4,Listener.class,$(GRAMMARS))
BASELISTENER_CLASS := $(subst .g4,BaseListener.class,$(GRAMMARS))

AUTO_CLASSES := \
	$(LEXER_CLASS) \
	$(PARSER_CLASS) \
	$(BASELISTENER_CLASS)

.SECONDARY: $(subst .class,.java,$(AUTO_CLASSES) $(MAIN_CLASS))

# By default, for each grammar we produce listeners and visitors.
# Remove when unnecessary.

%Parser.java %Lexer.java %Listener.java %BaseListener.java: %.g4
	antlr4 $^ -listener -visitor

%Main.java:
	@echo "------ Generate file \"$@\" ------"
	@read -p "*** Grammar entry rule? " rule; \
	while true; do \
	    read -p "*** Line-by-line processing? " yn; \
	    case $$yn in \
		[Yy]* ) rule="$$rule -i"; \
			break;; \
		[Nn]* ) break;; \
		* ) echo "Please answer yes or no";; \
	    esac; \
	done; \
	while true; do \
	    read -p "*** Use listeners? " yn; \
	    case $$yn in \
		[Yy]* ) read -p "Listeners's class? " class; \
			rule="$$rule -l $$class"; \
			warning="Don't forget to change the Makefile to include a dependency from class $$class\n"; \
			break;; \
		[Nn]* ) break;; \
		* ) echo "Please answer yes or no";; \
	    esac; \
	done; \
	while true; do \
	    read -p "*** Use visitors? " yn; \
	    case $$yn in \
		[Yy]* ) read -p "Visitor's class? " class; \
			rule="$$rule -v $$class"; \
			warning="Don't forget to change the Makefile to include a dependency from class $$class\n"; \
			break;; \
		[Nn]* ) break;; \
		* ) echo "Please answer yes or no";; \
	    esac; \
	done; \
	antlr4-main $* $$rule; \
	echo "------ done ------"

%.class: %.java
	javac $*.java

main: $(MAIN_CLASS) $(AUTO_CLASSES)

# Add dependencies of Listener/Visitor classes from:
#     - Their direct source code
#     - Their automatic Listener/Visitor source code

MyCListener.class: MyCListener.java LCalculatorListener.java LCalculatorBaseListener.java
	javac MyCListener.java

MyCVisitor.class: MyCVisitor.java VCalculatorListener.java VCalculatorBaseListener.java
	javac MyCVisitor.java

# Add dependencies of Main classes from
#     - Its source code
#     - one automatic (compiled) class (Parser, in this case).
#     - non-automatic Listeners/Visitors used (if any)

CalculatorMain.class: CalculatorMain.java CalculatorParser.class
	javac CalculatorMain.java

LCalculatorMain.class: LCalculatorMain.java LCalculatorParser.class MyCListener.class
	javac LCalculatorMain.java

VCalculatorMain.class: VCalculatorMain.java VCalculatorParser.class MyCVisitor.class
	javac VCalculatorMain.java

# Clean all automatic files

clean:
	antlr4-clean

# Clean all automatic files and semi-automatic Main files

deep-clean:
	-antlr4-clean
	-rm $(subst .class,.java,$(MAIN_CLASS))
